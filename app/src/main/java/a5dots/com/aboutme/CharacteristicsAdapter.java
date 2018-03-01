package a5dots.com.aboutme;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import static com.squareup.picasso.Picasso.with;

/**
 * Created by alexscrobot on 30.01.18.
 */

public class CharacteristicsAdapter extends RecyclerView.Adapter<CharacteristicsAdapter.ViewHolder> {

    private List<CharHolder> chars;
    private Picasso picasso;

    public CharacteristicsAdapter(List<CharHolder> chars) {
        this.chars = chars;
    }
    //    public void fill(CharHolder charHolder) {
//        chars.add(charHolder);
////        chars.add(new CharHolder(R.drawable.interest , R.string.interest));
//
//        // TODO: прописать тут что-то чтобы адаптер обновился
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        picasso = with(parent.getContext());

        View v = null;

        switch (viewType) {

            case 0:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_char, parent, false);
                break;


            case 2:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_char_2, parent, false);
                break;
        }

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        CharHolder charHolder = getCharHolder(position);
        holder.mTextView.setText(charHolder.getTitleHolder());
        picasso.load(charHolder.getImg()).fit().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {

        return chars.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView mTextView;
        protected ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.title_char_item);
            mImageView = (ImageView) itemView.findViewById(R.id.image_char_item);

        }
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 * 2;
    }



    private CharHolder getCharHolder(int position){
        return (CharHolder) getItem(position);
    }

    private Object getItem(int position) {
        return chars.get(position);
    }
//
//    private List<CharHolder> charData(){
//        List<CharHolder> list = new ArrayList();
//
//        list.add(new CharHolder(R.drawable.interest , R.string.interest));
//        return list;
//    }

}
