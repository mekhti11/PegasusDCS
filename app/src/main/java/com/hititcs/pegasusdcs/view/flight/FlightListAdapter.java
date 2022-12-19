package com.hititcs.pegasusdcs.view.flight;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.hititcs.pegasusdcs.R;
import com.hititcs.pegasusdcs.domain.model.DepartingFlight;
import com.hititcs.pegasusdcs.util.DateTimeUtils;

import java.util.ArrayList;
import java.util.List;

public class FlightListAdapter extends RecyclerView.Adapter<FlightListViewHolder> {

  private List<DepartingFlight> flightSummaryList = new ArrayList<>();
  private FlightOnClickListener flightOnClickListener;
  private Drawable companyLogo;

  public FlightListAdapter(FlightOnClickListener flightOnClickListener, Drawable companyLogo) {
    this.flightOnClickListener = flightOnClickListener;
    this.companyLogo = companyLogo;
  }

  public void update(List<DepartingFlight> newFlightSummaryList) {
    flightSummaryList.clear();
    flightSummaryList.addAll(newFlightSummaryList);
    notifyDataSetChanged();
  }

  public void setFlightSummaryList(List<DepartingFlight> flightSummaryList) {
    this.flightSummaryList = flightSummaryList;
  }

  @NonNull
  @Override
  public FlightListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new FlightListViewHolder(
        LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_flight_list_card, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull FlightListViewHolder holder, int position) {
    DepartingFlight df = flightSummaryList.get(position);

    holder.getTvFlightNumber().setText(String
        .format("%s%s", df.getAaCode(),
            df.getFlightNo()));
    if (df.getDeparture()!=null && df.getDeparture().getLocalTime()!=null)
      holder.getTvDepDate().setText(df.getDeparture().getLocalTime().substring(11, 16));

    if (df.getArrivalList().size()>0) {
      if (df.getArrivalList().get(0).getLocalTime() != null)
        holder.getTvArrDate().setText(df.getArrivalList().get(0).getLocalTime().substring(11, 16));
      if (df.getArrivalList().get(0).getLocation()!=null && df.getArrivalList().get(0).getLocation().getPortCode()!=null)
        holder.getTvArrPort().setText(df.getArrivalList().get(0).getLocation().getPortCode());
    }

    if (df.getDeparture()!=null)
      if (df.getDeparture().getLocation()!=null && df.getDeparture().getLocation().getPortCode()!=null)
        holder.getTvDepPort().setText(df.getDeparture().getLocation().getPortCode());

    holder.getTvGate().setText(df.getBoardingGate());
    if(companyLogo != null) {
      holder.getIvCompanyLogo().setImageDrawable(companyLogo);
      holder.getIvCompanyLogo().setVisibility(View.VISIBLE);
    }else{
      holder.getIvCompanyLogo().setVisibility(View.INVISIBLE);
    }
    holder.getTvFlightStatus().setText(String.format("%s: %s",
        holder.itemView.getContext().getString(R.string.item_flight_flight_status),
        flightSummaryList.get(position).getStatus()));
    holder.getTvBoardingTime().setText(String.format("%s: %s",
        holder.itemView.getContext().getString(R.string.item_flight_boarding_time),
        DateTimeUtils
            .getTimeFromZonedDateTime(flightSummaryList.get(position).getBoardingTime())));
    holder.itemView.setOnClickListener(
        v -> flightOnClickListener.startFlightDetailActivity(flightSummaryList.get(position),position));
//    if (flightSummaryList.get(position).isVisible()) {
      holder.getCvItemFlight().setVisibility(View.VISIBLE);
//    } else {
//      holder.getCvItemFlight().setVisibility(View.GONE);
//    }
  }

  @Override
  public int getItemCount() {
    return  flightSummaryList.size() ;
  }

  public interface FlightOnClickListener {

    void startFlightDetailActivity(DepartingFlight flightSummary,int position);
  }

}
