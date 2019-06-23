package com.github.skyfe79.materialtablayout

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


class DemoFragment: Fragment() {
    private var title: String? = null//String for tab title

    companion object {
        private val TAB_TITLE = "tab_title"
        fun newInstance(title: String): DemoFragment {

            val args = Bundle()
            args.putString(TAB_TITLE, title)
            val fragment = DemoFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //fetch the title from passed arguments
        title = arguments!!.getString(TAB_TITLE)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.demo_fragment, container, false)
        setRecyclerView(view)
        return view

    }

    //Setting recycler view
    private fun setRecyclerView(view: View) {

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)//Linear Items


        val items = mutableListOf<String>()
        for (i in 0..19) {
            items.add("$title Items $i")//Adding items to recycler view
        }
        val adapter = RecyclerViewAdapter(items)
        recyclerView.adapter = adapter// set adapter on recyclerview

    }
}