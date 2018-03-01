package a5dots.com.aboutme;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.Window;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private RecyclerView mRecyclerExtra;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManagerExtra;
    private ImageView mUserPhoto, mItemImage;
    private GridView mGridView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mUserPhoto = (ImageView) findViewById(R.id.user_photo_img);
        mItemImage = (ImageView) findViewById(R.id.image_char_item);



        List<CharHolder> listCH = fill();

        mRecyclerExtra = (RecyclerView) findViewById(R.id.recycler_extra);
        mRecyclerExtra.setHasFixedSize(true);

        mLayoutManagerExtra = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerExtra.setLayoutManager(mLayoutManagerExtra);

        mAdapter = new CharacteristicsAdapter(listCH);
        mRecyclerExtra.setAdapter(mAdapter);

        Picasso.with(this).load(R.drawable.about_me_avatar).fit().into(mUserPhoto);




    }



    private List<CharHolder> fill(){
        List<CharHolder> list = new ArrayList<>();
        list.add(new CharHolder(R.drawable.interest, R.string.interest));
        list.add(new CharHolder(R.drawable.skills, R.string.skills));
        return list;
    }
}
