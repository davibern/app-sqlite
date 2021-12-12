package davibern.app_sqlite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import davibern.app_sqlite.entities.User;

public class AdapterUserData extends RecyclerView.Adapter<AdapterUserData.ViewHolderData> {

    private Context context;
    private ArrayList<User> listUser;
    private User user;

    public AdapterUserData(ArrayList<User> listUser, Context context) {
        this.listUser = listUser;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_list, null, false);
        return new ViewHolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderData holder, int position) {
        holder.txtId.setText(listUser.get(position).getId().toString());
        holder.txtName.setText(listUser.get(position).getName());
        holder.txtPhone.setText(listUser.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {

        TextView txtId, txtName, txtPhone;

        public ViewHolderData(@NonNull View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txtItemRecyclerId);
            txtName = itemView.findViewById(R.id.txtItemRecyclerName);
            txtPhone = itemView.findViewById(R.id.txtItemRecyclerPhone);

            itemView.findViewById(R.id.btnDetailRecyclerView).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    user = listUser.get(Integer.parseInt(txtId.getText().toString()) - 1);
                    Intent i = new Intent(context, UserDetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user", user);
                    i.putExtras(bundle);
                    context.startActivity(i);
                }
            });
        }

    }
}
