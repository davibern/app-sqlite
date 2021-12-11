package davibern.app_sqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import davibern.app_sqlite.entities.User;

public class AdapterUserData extends RecyclerView.Adapter<AdapterUserData.ViewHolderData> {

    ArrayList<User> listUser;

    public AdapterUserData(ArrayList<User> listUser) {
        this.listUser = listUser;
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
        }

    }
}
