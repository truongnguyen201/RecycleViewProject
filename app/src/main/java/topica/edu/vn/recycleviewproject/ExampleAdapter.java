package topica.edu.vn.recycleviewproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private  ArrayList<ExampleItem> mExampleList;
    private OnItemclickListerner mListerner;

    public interface OnItemclickListerner
    {
        void onItemClick(int position);
        void onDeleteClick(int position);
    }

    public void setOnItemclickListerner(OnItemclickListerner listerner)
    {
        mListerner=listerner;

    }
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        ExampleViewHolder exampleViewHolder=new ExampleViewHolder(v,mListerner);
        return exampleViewHolder;
    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleList)
    {
        mExampleList=exampleList;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem exampleItem=mExampleList.get(position);
        holder.mImageView.setImageResource(exampleItem.getImageResuurce());
        holder.mTextView1.setText(exampleItem.getmText1());
        holder.mTextView2.setText(exampleItem.getmText2());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public ImageButton mImageview2;

        public ExampleViewHolder(@NonNull View itemView,OnItemclickListerner listerner) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.imageView);
            mTextView1=itemView.findViewById(R.id.textView);
            mTextView2=itemView.findViewById(R.id.textView2);
            mImageview2=itemView.findViewById(R.id.image_delete);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listerner!=null)
                    {
                        int position=getAdapterPosition();//interface dược set position chinh mLister của lóp này
                        if(position!=RecyclerView.NO_POSITION)
                            listerner.onItemClick(position);
                    }
                }
            });
            mImageview2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listerner!=null)
                    {
                        int position=getAdapterPosition();//interface dược set position chinh mLister của lóp này
                        if(position!=RecyclerView.NO_POSITION)
                            listerner.onDeleteClick(position);
                    }
                }
            });
        }
    }

}
