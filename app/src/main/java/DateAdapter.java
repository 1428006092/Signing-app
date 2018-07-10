import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DateAdapter extends BaseAdapter{
    private int[]days=new int[42];
    private Context context;
    private int year;
    private int month;
    public DateAdapter(Context context,int[][]days,int year,int month){
        this.context=context;
        int dayNum=0;
        for(int i=0;i<days.length;i++){
            for(int j=0;j<days[i].length;j++){
                this.days[dayNum]=days[i][j];
                dayNum++;
            }
        }
        this.year=year;
        this.month=month;

    }

    @Override
    public int getCount() {
        return days.length;
    }

    @Override
    public Object getItem(int position) {
        return days[i];
    }

    @Override
    public long getItemId(int position) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view==null){
            view= LayoutInflater.from(context).inflate(android.support.compat.R.layout.date_item,null);
            viewHolder=new ViewHolder();
            viewHolder.date_item=(TextView)view.findViewById(android.support.graphics.drawable.R.id.date_item);
            view.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)view.getTag();
        }
        if(i<7&&days[i]>20){
            viewHolder.date_item.setTextColor(Color.rgb(204, 204, 204));

        }
        else if(i>20&&days[i]<15)
        {
            viewHolder.date_item.setTextColor(Color.rgb(204,204,204))

        }
        viewHolder.date_item.setText(days[i]+"");


        return view;
    }

    private class ViewHolder {
        TextView date_item;
    }
}
