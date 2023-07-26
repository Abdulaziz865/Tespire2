package naclai.ballon.wellin.white.ui.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import naclai.ballon.wellin.R

class CustomArrayAdapter(context: Context, resource: Int, objects: Array<String>) :
    ArrayAdapter<String>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent) as TextView
        view.setTextColor(ContextCompat.getColor(context, R.color.white))
        view.setBackgroundColor(ContextCompat.getColor(context, R.color.orange))

        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent) as TextView
        view.setTextColor(ContextCompat.getColor(context, R.color.white))
        view.setBackgroundColor(ContextCompat.getColor(context, R.color.orange))

        return view
    }
}