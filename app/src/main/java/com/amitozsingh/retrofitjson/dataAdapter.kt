package com.amitozsingh.retrofitjson


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.amitozsingh.retrofitjson.data.Doc
import com.ms.square.android.expandabletextview.ExpandableTextView
import kotlinx.android.synthetic.main.data_layout.view.*
import java.text.SimpleDateFormat


class dataAdapter(var context: Context, val namelist:List<Doc>): RecyclerView.Adapter<dataAdapter.myviewholder>() {



    override fun getItemCount(): Int {

            if (namelist != null) {
                return namelist.size

            }

        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {

        var li=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var itemView=li.inflate(R.layout.data_layout,parent,false)

       //var tvv = parent.findViewById(R.id.tv1) as ExpandableTextView
        return myviewholder(itemView)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: myviewholder, position: Int) {




        var item1= this.namelist[position]
        holder.itemView.title.text= item1.titleDisplay
        holder.itemView.journal.text= item1.journal

        val dtStart = item1.publicationDate
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")

            val date = format.parse(dtStart)

       holder.itemView.date.text= date.toString()
        var mystring: String = " "
        var abc= item1.authorDisplay
        for(i in 0..abc.size-1)
        {
            if(i!=abc.size-1) {
                mystring += abc[i] + " ,"
            }
            else {
                mystring += abc[i]
            }

        }
        if(mystring!=" ") {
            holder.itemView.author.text = "Author : "+mystring
        }
        else{
            holder.itemView.author.text = "\"Author : Not Available"
        }

        var mystring2:String=" "
        var abc2=item1.abstract
        for(i in 0..abc2.size-1)
            mystring2+=abc2[i]

        if(mystring2!=" ") {
            holder.itemView.tv1.text = mystring2
        }
        else{
            holder.itemView.tv1.text = "Not Available"
        }







        var  plus =  holder.itemView.findViewById<ImageButton>(R.id.plus)
        var  minus =  holder.itemView.findViewById<ImageButton>(R.id.minus)

        plus.setOnClickListener {

            plus.visibility = View.GONE
            minus.setVisibility(View.VISIBLE)
            holder.itemView.tv1.setMaxLines(Integer.MAX_VALUE)
        }
        minus.setOnClickListener {

            minus.setVisibility(View.GONE);
            plus.setVisibility(View.VISIBLE);
           holder.itemView.tv1.setMaxLines(5);
        }







    }
    inner class myviewholder(itemView: View):RecyclerView.ViewHolder(itemView)

}