package org.androidtown.signalapplication.Activities;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.os.EnvironmentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import org.androidtown.signalapplication.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mCameraButton, mAlbumButton;

    private static final int PIC_FROM_CAMERA = 1;
    private static final int PIC_FROM_ALBUM = 2;
    private static final int CROP_FROM_CAMERA = 3;

    private Uri imgUri;
    private String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
    private static final int MULITPLE_PERMISSIONS = 101;

    private String mCurrentImgPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_image);
        checkPermissions();
        initView();
        //갤러리 버튼 > 갤러리에서 이미지 가져오기 > 크롭하기 > 레지스터로 보내기
        //카메라 버튼 > 사진촬영하기 > 크롭하기 > 레지스터로 보내기

    }

    private boolean checkPermissions() {
        int result;
        List<String> permissionList = new ArrayList<>();
        for(String pm: permissions) {
            result = ContextCompat.checkSelfPermission(this, pm);
            if(result!= PackageManager.PERMISSION_GRANTED){
                permissionList.add(pm);
            }
        }
        if(!permissionList.isEmpty()){
            ActivityCompat.requestPermissions(this,
                    permissionList.toArray(new String[permissionList.size()]),
                    MULITPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    private void initView() {
        mCameraButton = (Button) findViewById(R.id.img_camera_button);
        mAlbumButton = (Button) findViewById(R.id.img_album_button);

        mCameraButton.setOnClickListener(this);
        mAlbumButton.setOnClickListener(this);
    }

    private  void takePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File mImgFile = null;
        try {
            mImgFile = createImageFile();
        } catch (IOException e) {
            Toast.makeText(ImageActivity.this, "이미지 처리 오류! 다시 시도해주세요", Toast.LENGTH_SHORT).show();
            finish();
            e.printStackTrace();
        }

        if(mImgFile != null) {
            imgUri = FileProvider.getUriForFile(ImageActivity.this, "com.signalproject.provider", mImgFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
            startActivityForResult(intent, PIC_FROM_CAMERA);
        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("HHmmss").format(new Date());
        String imgFileName = "signal_"+timeStamp+"_";
        File storageDir = new File(Environment.getExternalStorageDirectory()+"/Signal/");
        if(!storageDir.exists()){
            storageDir.mkdir();
        }
        File image = File.createTempFile(imgFileName, ".jpg", storageDir);
        mCurrentImgPath = "file:"+image.getAbsolutePath();
        return image;
    }

    private void goToAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PIC_FROM_ALBUM);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_camera_button:
                takePhoto();
                break;
            case R.id.img_album_button:
                goToAlbum();
                break;
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode){
            case MULITPLE_PERMISSIONS: {
                if(grantResults.length>0){
                    for(int i = 0; i<permissions.length; i++){
                        if(permissions[i].equals(this.permissions[0])) {
                            if(grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                                showNoPermissionToastAndFinish();
                            }
                        }else if(permissions[i].equals(this.permissions[1])) {
                            if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                                showNoPermissionToastAndFinish();
                            }
                        }else if(permissions[i].equals(this.permissions[2])) {
                            if(grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                                showNoPermissionToastAndFinish();
                            }
                        }
                    }
                } else {
                    showNoPermissionToastAndFinish();
                }
                return;
            }
        }
    }

    private void showNoPermissionToastAndFinish() {
        Toast.makeText(this, "권한 요청에 동의해주셔야 이용가능합니다 설정에서 권한 허용하시길 바랍니다", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != RESULT_OK) {
            Toast.makeText(this, "취소되었습니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(requestCode == PIC_FROM_ALBUM){
            if(data == null){
                return;
            }
            imgUri = data.getData();
            cropImg();
        } else if(requestCode == PIC_FROM_CAMERA) {
            cropImg();
            MediaScannerConnection.scanFile(ImageActivity.this,
                    new String[]{imgUri.getPath()},
                    null,
                    new MediaScannerConnection.OnScanCompletedListener(){
                public void onScanCompleted(String path, Uri uri) {

                }
            });
        } else if(requestCode == CROP_FROM_CAMERA) {
            mCurrentImgPath = imgUri.toString();
            Intent intent = new Intent(this, RegisterActivity.class);
            intent.putExtra("imgUri", mCurrentImgPath);
            startActivity(intent);
        }
    }

    public void cropImg() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            this.grantUriPermission("com.android.camera", imgUri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(imgUri, "image/*");

        List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent, 0);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            grantUriPermission(list.get(0).activityInfo.packageName, imgUri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }
        int size = list.size();
        if(size == 0){
            Toast.makeText(this, "취소되었습니다.", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Toast.makeText(this, "용량이 큰 사진의 경우 시간이 오래 걸릴 수 있습니다.", Toast.LENGTH_SHORT).show();
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            }
            intent.putExtra("crop", "true");
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("scale", true);
            File croppedFileName = null;
            try {
                croppedFileName = createImageFile();
            } catch (IOException e){
                e.printStackTrace();
            }

            File folder = new File(Environment.getExternalStorageDirectory() + "/Signal/");
            File tmpFile = new File(folder.toString(), croppedFileName.getName());

            imgUri = FileProvider.getUriForFile(ImageActivity.this, "com.signalproject.provider", tmpFile);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            }

            intent.putExtra("returndata", false);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
            intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());

            Intent i = new Intent(intent);
            ResolveInfo res = list.get(0);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                i.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                grantUriPermission(res.activityInfo.packageName, imgUri,
                        Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
            }
            i.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            startActivityForResult(i, CROP_FROM_CAMERA);
        }

    }
}
