package com.zeuschan.littlefreshweather.prsentation.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.zeuschan.littlefreshweather.model.entity.WeatherEntity;
import com.zeuschan.littlefreshweather.prsentation.R;

import java.util.List;

//import butterknife.BindView;
//import butterknife.ButterKnife;

/**
 * Created by chenxiong on 2016/6/13.
 */
public class ForecastAdapter extends ArrayAdapter<WeatherEntity.Forecast> {

    int mResourceId;

    public ForecastAdapter(Context context, int resource, List<WeatherEntity.Forecast> objects) {
        super(context, resource, objects);
        this.mResourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        WeatherEntity.Forecast forecast = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (null == convertView) {
            view = LayoutInflater.from(getContext()).inflate(mResourceId, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }

        viewHolder.tvDate.setText(forecast.getDate());
        viewHolder.tvCentigrade.setText(forecast.getMinTemperature() + "℃ ~ " + forecast.getMaxTemperature() + "℃");
        viewHolder.tvWeatherDesc.setText(forecast.getWeatherDescriptionDaytime());

        return view;
    }

    public static class ViewHolder {
//        @BindView(R.id.tv_city_weather_forecast_item_date) TextView tvDate;
//        @BindView(R.id.tv_city_weather_forecast_item_centigrade) TextView tvCentigrade;
//        @BindView(R.id.tv_city_weather_forecast_item_weather_desc) TextView tvWeatherDesc;

        TextView tvDate;
        TextView tvCentigrade;
        TextView tvWeatherDesc;

        public ViewHolder(View itemView) {
            //ButterKnife.bind(this, itemView);
            tvDate = (TextView)itemView.findViewById(R.id.tv_city_weather_forecast_item_date);
            tvCentigrade = (TextView)itemView.findViewById(R.id.tv_city_weather_forecast_item_centigrade);
            tvWeatherDesc = (TextView)itemView.findViewById(R.id.tv_city_weather_forecast_item_weather_desc);
        }
    }
}
