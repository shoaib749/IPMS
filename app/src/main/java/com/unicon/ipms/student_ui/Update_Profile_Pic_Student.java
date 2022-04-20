package com.unicon.ipms.student_ui;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.PermissionRequest;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.single.PermissionListener;
import com.squareup.picasso.Picasso;
import com.unicon.ipms.MainActivity;
import com.unicon.ipms.R;
import com.unicon.ipms.constant;
import com.unicon.ipms.databinding.FragmentUpdateProfilePicStudentBinding;
import com.unicon.ipms.sharepref_moreInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


public class Update_Profile_Pic_Student extends Fragment {
    private FragmentUpdateProfilePicStudentBinding binding;
    ImageView imageView;
    TextView TV_update;
    Bitmap bitmap;
    String encodeImageString;
    String image_path;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUpdateProfilePicStudentBinding.inflate(inflater,container,false);
        imageView=binding.profilePicIV;
        TV_update=binding.BUpdateProfilePic;
        getImage();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPermission();
            }
        });
        TV_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploaddatatodb();
            }
        });
//        return inflater.inflate(R.layout.fragment_update__profile__pic__student, container, false);
        return binding.getRoot();

    }

    private void getImage() {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                constant.URL_STUDENT_FETCH_PROFILE_PIC,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject object = new JSONObject(response);
                            if(!object.getBoolean("error")){
                                if(object.getString("profile_img") == ""){
                                    Toast.makeText(getContext(), "no profile_pic", Toast.LENGTH_SHORT).show();
                                }else{
                                    image_path  = "http://192.168.29.240/IPMS_Script/images/"+object.getString("profile_img");
                                    sharepref_moreInfo.getInstance(getContext()).setProfile_url(image_path);
                                    Log.e("Path",image_path);
                                    Picasso.get()
                                            .load(image_path)
                                            .into(imageView);
                                }
                            }else{
                                Toast.makeText(getContext(), "Some error"+object.getString("message"), Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(getContext(), "error"+error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("email_id",sharepref_moreInfo.getInstance(getContext()).getemail());
                return params;
            }
        };
        RequestQueue queue= Volley.newRequestQueue(getContext());
        queue.add(stringRequest);
    }
    //start of test section
//    class ImageLoadTask extends AsyncTask<Void, Void, Bitmap> {
//        private String url;
//        private ImageView imageView;
//
//        public ImageLoadTask(String url, ImageView imageView) {
//            this.url = url;
//            this.imageView = imageView;
//        }
//
//        @Override
//        protected Bitmap doInBackground(Void... params) {
//            try {
//                URL connection = new URL(url);
//                InputStream input = connection.openStream();
//                Bitmap myBitmap = BitmapFactory.decodeStream(input);
//                Bitmap resized = Bitmap.createScaledBitmap(myBitmap, 400, 400, true);
//                return resized;
//            } catch (Exception e) {
//                Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
//            }
//            return null;
//        }
//        @Override
//        protected void onPostExecute(Bitmap result) {
//            super.onPostExecute(result);
//            imageView.setImageBitmap(result);
//        }
//    }
//    ImageLoadTask obj=new ImageLoadTask(image_path,imageView);
//            obj.execute();
    //end of test section

    private void getPermission() {
        Dexter.withActivity(getActivity())
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response)
                    {
                        Intent intent=new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(Intent.createChooser(intent,"Browse Image"),1);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(com.karumi.dexter.listener.PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }

                }).check();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if(requestCode==1 && resultCode==RESULT_OK)
        {
            Uri filepath=data.getData();
            try
            {
                Context applicationContext = MainActivity.getContextOfApplication();

                InputStream inputStream=applicationContext.getContentResolver().openInputStream(filepath);
                bitmap= BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
                encodeBitmapImage(bitmap);
            }catch (Exception ex)
            {

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void encodeBitmapImage(Bitmap bitmap)
    {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] bytesofimage=byteArrayOutputStream.toByteArray();
        encodeImageString=android.util.Base64.encodeToString(bytesofimage, Base64.DEFAULT);
    }

    private void uploaddatatodb()
    {
        final String email = sharepref_moreInfo.getInstance(getContext()).getemail();

        StringRequest request=new StringRequest(Request.Method.POST, constant.URL_STUDENT_PROFILE_PIC, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                Toast.makeText(getContext(),response.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),error.toString(),Toast.LENGTH_LONG).show();
                Log.e("error in volley",error.toString());
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> map=new HashMap<String, String>();
                map.put("email_id",email);
                map.put("upload",encodeImageString);
                return map;
            }
        };


        RequestQueue queue= Volley.newRequestQueue(getContext());
        queue.add(request);
    }
}