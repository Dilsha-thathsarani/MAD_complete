//package com.example.bookmark.category_management;
//
//
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.bookmark.R;
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.material.textfield.TextInputEditText;
//import com.google.firebase.database.FirebaseDatabase;
//import com.orhanobut.dialogplus.DialogPlus;
//import com.orhanobut.dialogplus.ViewHolder;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//
//public class CategoryAdapter extends FirebaseRecyclerAdapter<CategoryModule,CategoryAdapter.myViewHolder> {
//
//    /**
//     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
//     * {@link FirebaseRecyclerOptions} for configuration options.
//     *
//     * @param options
//     */
//
//
//    public CategoryAdapter(@NonNull FirebaseRecyclerOptions<com.example.bookmark.category_management.CategoryModule>
//                                   options) { super(options);
//    }
//
//    @Override
//    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull CategoryModule model) {
//
//        holder.product.setText(model.getProduct());
//
//
//
//        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.product.getContext())
//                        .setContentHolder(new ViewHolder(R.layout.update_popupcat))
//                        .setExpanded(true,1000)
//                        .create();
//               // dialogPlus.show();
//                View view = dialogPlus.getHolderView();
//
//                EditText category = view.findViewById(R.id.txtCAT);
//
//
//                Button btnUpdate = view.findViewById(R.id.btnUpdate);
//
//                //set data to edittext
//                category.setText(model.getProduct());
//
//
//                dialogPlus.show();
//
//                btnUpdate.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Map<String,Object> map= new HashMap<>();
//                        map.put("category",category.getText().toString());
//
//
//                        FirebaseDatabase.getInstance().getReference().child("Categories")
//                                .child(getRef(position).getKey()).updateChildren(map)
//                                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                    @Override
//                                    public void onSuccess(Void unused) {
//                                        Toast.makeText(holder.product.getContext(), "Updated Sucessfully", Toast.LENGTH_SHORT).show();
//                                        dialogPlus.dismiss();
//                                    }
//                                })
//                                .addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure( Exception e) {
//                                        Toast.makeText(holder.product.getContext(), "Error while Updating", Toast.LENGTH_SHORT).show();
//                                        dialogPlus.dismiss();
//                                    }
//                                });
//                    }
//                });
//
//            }
//        });
//
//        //Delete Category
//      holder.btnDelete.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View v) {
//              AlertDialog.Builder builder = new AlertDialog.Builder(holder.product.getContext());
//
//              builder.setTitle("Are you sure ?");
//              builder.setMessage("Deleted data can't be Undo ");
//
//              builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
//                  @Override
//                  public void onClick(DialogInterface dialog, int which) {
//
//                      FirebaseDatabase.getInstance().getReference().child("Categories")
//                              .child(Objects.requireNonNull(getRef(position).getKey())).removeValue();
//
//                  }
//              });
//
//              builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                  @Override
//                  public void onClick(DialogInterface dialog, int which) {
//                      Toast.makeText(holder.product.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
//                  }
//              });
//
//              builder.show();
//
//          }
//      });
//
//
//
//    }
//
//    @NonNull
//    @Override
//    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_one,parent,false);
//        return new myViewHolder(view);
//    }
//
//    class myViewHolder extends RecyclerView.ViewHolder{
//
//        TextInputEditText product;
//
//        Button btnEdit,btnDelete;
//
//        public myViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//             product = (TextInputEditText) itemView.findViewById(R.id.txtname1);
//
//            btnEdit = (Button)itemView.findViewById(R.id.btnEdit);
//            btnDelete = (Button)itemView.findViewById(R.id.btnDelete);
//
//        }
//    }
//
//}
