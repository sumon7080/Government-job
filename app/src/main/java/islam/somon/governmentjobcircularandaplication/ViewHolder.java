package islam.somon.governmentjobcircularandaplication;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {
    private View imageView;


    public ViewHolder(@NonNull View itemView)
    {
        super(itemView);
        imageView = itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());



            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());
                return true;
            }
        });

    }

    public void setDetails(Context ctx, String title, String image){

        TextView mTitle = imageView.findViewById(R.id.rTitleTv);
        ImageView mImage = imageView.findViewById(R.id.rImage);


        mTitle.setText(title);

        Picasso.get().load(image).into(mImage);

    }
    private ViewHolder.ClickListener mClickListener;
    public interface ClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnClickListener (ViewHolder.ClickListener clickListener){

        mClickListener = clickListener;
    }

}
