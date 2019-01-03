package yocxli.flipreminder.board.list

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_board.view.*
import yocxli.flipreminder.R


import yocxli.flipreminder.board.list.BoardFragment.OnListFragmentInteractionListener

import yocxli.flipreminder.domain.Board

/**
 *
 */
class BoardRecyclerViewAdapter(
    private val values: List<Board>,
    private val listener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<BoardRecyclerViewAdapter.ViewHolder>() {

    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            val item = v.tag as Board
            listener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_board, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.label.text = item.label

        with(holder.mView) {
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val image: ImageView = mView.image
        val label: TextView = mView.label

        override fun toString(): String {
            return super.toString() + " '" + label.text + "'"
        }
    }
}
