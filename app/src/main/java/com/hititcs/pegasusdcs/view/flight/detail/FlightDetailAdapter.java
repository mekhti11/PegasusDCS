package com.hititcs.pegasusdcs.view.flight.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hititcs.pegasusdcs.R;
import com.hititcs.pegasusdcs.domain.model.DepartingFlight;
import com.hititcs.pegasusdcs.domain.model.MobileDcsFlight;
import com.hititcs.pegasusdcs.util.DateTimeUtils;
import com.hititcs.pegasusdcs.view.ItemViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlightDetailAdapter extends RecyclerView.Adapter<FlightDetailAdapter.FlightDetailListViewHolder> {

    private MobileDcsFlight flightDetailList;

    public FlightDetailAdapter(MobileDcsFlight flightDetailList) {
        this.flightDetailList = flightDetailList;

    }



    @NonNull
    @Override
    public FlightDetailListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FlightDetailListViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_detail_rw, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FlightDetailListViewHolder holder, int position) {
        MobileDcsFlight df = flightDetailList;

        int size = df.getArrivalList().size();

        if (df.getDeparture()!=null && df.getDeparture().getLocalTime()!=null)
            holder.getTvDepDate().setText(df.getDeparture().getLocalTime().substring(11, 16));

        if (size>0) {
            if (df.getArrivalList().get(position).getLocalTime() != null)
                holder.getTvArrDate().setText(df.getArrivalList().get(position).getLocalTime().substring(11, 16));
            if (df.getArrivalList().get(position).getLocation()!=null && df.getArrivalList().get(position).getLocation().getPortCode()!=null)
                holder.getTvArrPort().setText(df.getArrivalList().get(position).getLocation().getPortCode());
        }

        if (df.getDeparture()!=null)
            if (df.getDeparture().getLocation()!=null && df.getDeparture().getLocation().getPortCode()!=null)
                holder.getTvDepPort().setText(df.getDeparture().getLocation().getPortCode());

        holder.getTvFlightStatus().setText(String.format("%s: %s",
                holder.itemView.getContext().getString(R.string.item_flight_flight_status),
                flightDetailList.getStatus()));


            if(position == 0){
                holder.getTvFlightStatus().setVisibility(View.VISIBLE);
                holder.getTvBoardingTime().setVisibility(View.VISIBLE);
            }
           else{
                holder.getTvFlightStatus().setVisibility(View.GONE);
                holder.getTvBoardingTime().setVisibility(View.GONE);
            }



        holder.getTvBoardingTime().setText(String.format("%s: %s",
                holder.itemView.getContext().getString(R.string.item_flight_boarding_time),
                DateTimeUtils
                        .getTimeFromZonedDateTime(flightDetailList.getBoardingTime())));

    }

    @Override
    public int getItemCount() {
        return  flightDetailList.getArrivalList().size() ;
    }
    public class FlightDetailListViewHolder extends ItemViewHolder {


        @BindView(R.id.tv_dep_port)
        TextView tvDepPort;
        @BindView(R.id.tv_arr_port)
        TextView tvArrPort;
        @BindView(R.id.tv_dep_date)
        TextView tvDepDate;
        @BindView(R.id.tv_arr_date)
        TextView tvArrDate;
        @BindView(R.id.tv_boarding_time)
        TextView tvBoardingTime;
        @BindView(R.id.tv_flight_status)
        TextView tvFlightStatus;


        public FlightDetailListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public TextView getTvDepPort() {
            return tvDepPort;
        }

        public TextView getTvArrPort() {
            return tvArrPort;
        }

        public TextView getTvDepDate() {
            return tvDepDate;
        }

        public TextView getTvArrDate() {
            return tvArrDate;
        }

        public TextView getTvBoardingTime() {
            return tvBoardingTime;
        }



        public TextView getTvFlightStatus() {
            return tvFlightStatus;
        }


    }


}
