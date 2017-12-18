package com.ntanougat.rainbow.ui.activity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.goyourfly.multi_picture.ImageLoader;
import com.goyourfly.multi_picture.MultiPictureView;
import com.ntanougat.rainbow.R;
import com.ntanougat.rainbow.WebService.UpLoadStoryService;
import com.ntanougat.rainbow.entities.IsTureBean;
import com.ntanougat.rainbow.utils.MatisseUtil;
import com.ntanougat.rainbow.webApi.UpLoadStoryApi;
import com.squareup.picasso.Picasso;
import com.zhihu.matisse.Matisse;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Peelson on 2017/12/17.
 */

public class NewStoryActivity extends AppCompatActivity {


    @BindView(R.id.ed_title)
    EditText ed_title;
    @BindView(R.id.ed_content)
    EditText ed_content;
    @BindView(R.id.fbtn_done)
    FloatingActionButton fbtn_done;
    private String content;
    private String title;
    private String userId = "123456";
    List<String> imgPathList = new ArrayList<>();


    @BindView(R.id.multiple_image)
    MultiPictureView multiPictureView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newstory);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        initMultiPictureView();
        multipleimageClick();
        fbtn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed_title.getText()!=null&&ed_content.getText()!=null&&multiPictureView.getList().size()!=0){
                    title=ed_title.getText().toString();
                    content=ed_content.getText().toString();
                    for (int i=0;i<multiPictureView.getList().size();i++){
                        imgPathList.add(getRealPathFromUri(multiPictureView.getList().get(i)));
                    }
                    upLoadStory();
                }else{

                }
            }
        });
    }

    private void initMultiPictureView() {
        MultiPictureView.setImageLoader(new ImageLoader() {
            @Override
            public void loadImage(ImageView imageView, Uri uri) {
                Picasso.with(NewStoryActivity.this)
                        .load(uri)
                        .into(imageView);
            }
        });
    }

    private void multipleimageClick() {
        Log.i("muitipleimage","OOOOOOOOOOncliked");
        multiPictureView.setAddClickCallback(new MultiPictureView.AddClickCallback() {
            @Override
            public void onAddClick(@NotNull View view) {
                MatisseUtil util = new MatisseUtil(NewStoryActivity.this, multiPictureView);
            }
        });
    }

    private void upLoadStory() {
        RequestBody rb_userId = RequestBody.create(null, userId);
        RequestBody id1 = RequestBody.create(null, "1");
        RequestBody id2 = RequestBody.create(null, "2");
        RequestBody id3 = RequestBody.create(null, "3");
        RequestBody id4 = RequestBody.create(null, "4");
        RequestBody id5 = RequestBody.create(null, "5");
        MultipartBody.Part img5;
        MultipartBody.Part img4;
        MultipartBody.Part img3;
        MultipartBody.Part img2;
        MultipartBody.Part img1;
        File file1;
        File file2;
        File file3;
        File file4;
        File file5;
        RequestBody rb_title = RequestBody.create(null, title);
        RequestBody rb_content = RequestBody.create(null, content);
        UpLoadStoryApi upLoadStoryApi = new UpLoadStoryApi();
        UpLoadStoryService upLoadStoryService = upLoadStoryApi.getService();
        Call<IsTureBean> call_upLoad = null;
        switch (imgPathList.size()) {
            case 5:
                file5 = new File(imgPathList.get(4));
                img5 = MultipartBody.Part.createFormData("file", file5.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file5));
                file1 = new File(imgPathList.get(0));
                img1 = MultipartBody.Part.createFormData("file", file1.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file1));
                file2 = new File(imgPathList.get(1));
                img2 = MultipartBody.Part.createFormData("file", file2.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file2));
                file3 = new File(imgPathList.get(2));
                img3 = MultipartBody.Part.createFormData("file", file3.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file3));
                file4 = new File(imgPathList.get(3));
                img4 = MultipartBody.Part.createFormData("file", file4.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file4));
                call_upLoad = upLoadStoryService.getByFive(rb_userId, rb_title, id1, rb_content, img1, id2, rb_content, img2, id3, rb_content, img3, id4, rb_content, img4, id5, rb_content, img5);
                break;
            case 4:
                file1 = new File(imgPathList.get(0));
                img1 = MultipartBody.Part.createFormData("file", file1.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file1));
                file2 = new File(imgPathList.get(1));
                img2 = MultipartBody.Part.createFormData("file", file2.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file2));
                file3 = new File(imgPathList.get(2));
                img3 = MultipartBody.Part.createFormData("file", file3.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file3));
                file4 = new File(imgPathList.get(3));
                img4 = MultipartBody.Part.createFormData("file", file4.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file4));
                call_upLoad = upLoadStoryService.getByFour(rb_userId, rb_title, id1, rb_content, img1, id2, rb_content, img2, id3, rb_content, img3, id4, rb_content, img4);
                break;
            case 3:
                file1 = new File(imgPathList.get(0));
                img1 = MultipartBody.Part.createFormData("file", file1.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file1));
                file2 = new File(imgPathList.get(1));
                img2 = MultipartBody.Part.createFormData("file", file2.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file2));
                file3 = new File(imgPathList.get(2));
                img3 = MultipartBody.Part.createFormData("file", file3.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file3));
                call_upLoad = upLoadStoryService.getByThree(rb_userId, rb_title, id1, rb_content, img1, id2, rb_content, img2, id3, rb_content, img3);
                break;
            case 1:
                file1 = new File(imgPathList.get(0));
                img1 = MultipartBody.Part.createFormData("file", file1.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file1));
                call_upLoad = upLoadStoryService.getByOne(rb_userId, rb_title, id1, rb_content, img1);
                break;
            case 2:
                file1 = new File(imgPathList.get(0));
                img1 = MultipartBody.Part.createFormData("file", file1.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file1));
                file2 = new File(imgPathList.get(1));
                img2 = MultipartBody.Part.createFormData("file", file2.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file2));
                call_upLoad = upLoadStoryService.getByTwo(rb_userId, rb_title, id1, rb_content, img1, id2, rb_content, img2);
            default:
                break;
        }
        call_upLoad.enqueue(new Callback<IsTureBean>() {
            @Override
            public void onResponse(Call<IsTureBean> call, Response<IsTureBean> response) {
                if (response.body().getResult().equals("1")) {
                    Log.i("uploadStorySeccess", userId);
                }
                if(response.body().getResult().equals("0")){
                    Toast.makeText(getApplicationContext(),"上传失败~",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<IsTureBean> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"上传失败！",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            switch (requestCode) {
                case MatisseUtil.REQUEST_ADD_IMAGE:
                    //添加图片显示
                    multiPictureView.addItem(Matisse.obtainResult(data));
                    break;
                default:
                    break;
            }
        }
    }

    public String getRealPathFromUri(Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            cursor = getContentResolver().query(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
