package com.example.googlesignin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.googlesignin.Activity.GetRestaurantLocationDataActivity;
import com.example.googlesignin.Model.DegreeDataModel;
import com.example.googlesignin.Model.RestaurantDataModel;
import com.example.googlesignin.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurntDataAdapter extends RecyclerView.Adapter<RestaurntDataAdapter.MyViewHolder> {
    Context context;
    List<RestaurantDataModel> restaurantDataModelList;
    List<DegreeDataModel> degreeDataModels;

    public RestaurntDataAdapter(Context context, List<RestaurantDataModel> restaurantDataModels, List<DegreeDataModel> degreeDataModels) {
        this.context = context;
        this.restaurantDataModelList = restaurantDataModels;
        this.degreeDataModels = degreeDataModels;
    }

    @NonNull
    @Override
    public RestaurntDataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from( viewGroup.getContext() )
                .inflate( R.layout.recycler_data_card_view, viewGroup, false );

        return new MyViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurntDataAdapter.MyViewHolder holder, final int position) {

        // Glide.with( context ).load( position ).into( holder.orderImage );
        holder.jobnumber.setText( restaurantDataModelList.get( position ).getJobid() );
        holder.company.setText( restaurantDataModelList.get( position ).getCompany() );
        holder.address.setText( restaurantDataModelList.get( position ).getAddress() );
//       holder.address.setText( restaurantDataModelList.get( position ).getDegreeDataModel().getLatitude() );
        holder.cardView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( context, GetRestaurantLocationDataActivity.class );
                i.putExtra( "adr", restaurantDataModelList.get( position ).getAddress() );
//                i.putExtra( "longi", restaurantDataModelList.get( position ).getDegreeDataModel().getLongitude() );
              //  i.putExtra( "lati", restaurantDataModelList.get( position ).getDegreeDataModel().getLatitude() );
                i.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
                context.startActivity( i );

            }
        } );

        holder.btn_accept.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText( context, "Accept the job", Toast.LENGTH_SHORT ).show();


            }
        } );


    }

    @Override
    public int getItemCount() {
        return restaurantDataModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView jobnumber, address, company;
        Button btn_accept;
        ImageView orderImage;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super( itemView );

            jobnumber = itemView.findViewById( R.id.jobno );
            address = itemView.findViewById( R.id.address );
            company = itemView.findViewById( R.id.company );
            btn_accept = itemView.findViewById( R.id.accept );
            orderImage = itemView.findViewById( R.id.photo );
            cardView = itemView.findViewById( R.id.cv_req );


        }
    }
}
