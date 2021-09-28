//package com.example.bookmark.category_management;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Toast;
//
//import com.example.bookmark.R;
//import com.example.bookmark.databinding.ActivityAddCategoryBinding;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import java.util.HashMap;
//
//public class AddCategory extends AppCompatActivity {
//
//    //view binding
//    private ActivityAddCategoryBinding binding;
//
//    //firebase auth
//
//
//    //progress dialog
//    private ProgressDialog progressDialog;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityAddCategoryBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        binding.CAT2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(AddCategory.this,DisplayCategory.class));
//            }
//        });
//
//        //init firebase
//
//        //configure progress dialog
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setTitle("Pls Wait");
//        progressDialog.setCanceledOnTouchOutside(false);
//
//        //handle click
//        binding.add1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                validateData();
//            }
//        });
//    }
//
//
//
//    private String category=" ";
//    private String description = " ";
//
//
//    private void validateData() {
//        category = binding.categoryET.getText().toString().trim();
//        description = binding.categoryET1.getText().toString().trim();
//        //validate
//
//        if(TextUtils.isEmpty(category)){
//            Toast.makeText(this, "Please enter category", Toast.LENGTH_SHORT).show();
//        }else{
//            addCategoryFirebase();
//        }
//
//    }
//
//    private void addCategoryFirebase() {
//        //show
//        progressDialog.setMessage("Adding category");
//        progressDialog.show();
//
//        //get timestamp
//        long timestamp = System.currentTimeMillis();
//
//        //add to firebase
//        HashMap<String,Object> hashMap = new HashMap<>();
//        hashMap.put("product",""+timestamp);
//        hashMap.put("description",""+category);
//         //hashMap.put("Description",""+description);
//        //hashMap.put("timestamp",""+timestamp);
//
//        //upload
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Books");
//        ref.child(""+timestamp)
//                .setValue(hashMap)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//                        //add successfull
//                        progressDialog.dismiss();
//                        Toast.makeText(AddCategory.this, "Category added successfully", Toast.LENGTH_SHORT).show();
//
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//
//                        progressDialog.dismiss();
//                        Toast.makeText(AddCategory.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//    }
//}

package com.example.bookmark.category_management;

import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.bookmark.R;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class AddCategory extends AppCompatActivity {


    private TextInputEditText categoryET;
    private Button add1;

//    private FirebaseStorage storage;
//    private StorageReference storageReference;
//
//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_add_category);

        categoryET = findViewById(R.id.categoryET);
        add1 = findViewById(R.id.add1);





        add1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                inputData();
            }

            private void inputData() {
                //input data
                String product = categoryET.getText().toString().trim();


                Book book = new Book();
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Books");



                book.setProduct(product);



                                reference.push().setValue(book);
                                Toast.makeText(AddCategory.this, "Category Added", Toast.LENGTH_SHORT).show();
                            }

                        });



//                book.setTitle(title);
//                book.setDescription(desc);
//                book.setPrice(price);
//                book.setProduct(product);
//                book.setDiscountPrice(discountPrice);
//                //book.setDiscountPrice2(discountPrice2);



                // book.setImage(downloadImageUri);

//                reference.push().setValue(book);
//                Toast.makeText(AddProduct.this, "Book Added", Toast.LENGTH_SHORT).show();
//                clearData();
//
//












/****************************************************************************************************************/

//                String timestamp = ""+System.currentTimeMillis();
//
//                if(image_uri == null){
//                    //upload without image
//                    //set data
//
//                    HashMap<String,Object> hashMap = new HashMap<>();
//                    hashMap.put("title",""+title);
//                    hashMap.put("Description", ""+desc);
//                    hashMap.put("price", ""+price);
//                      hashMap.put("production","");
//
//                    //add to db
//                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
//                    reference.push().setValue(hashMap)
//                            .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void unused) {
//                                    //added to db
//                                    Toast.makeText(AddProduct.this, "book added", Toast.LENGTH_SHORT).show();
//                                }
//                            })
//                            .addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(Exception e) {
//                                     //failed to db
//                                    Toast.makeText(AddProduct.this, "book added", Toast.LENGTH_SHORT).show();
//
//                                }
//                            });
//
//
//                }
//                else{
//
//
//              }
            }

            private void clearData() {
                //clear data
                categoryET.setText("");

            }


        }







