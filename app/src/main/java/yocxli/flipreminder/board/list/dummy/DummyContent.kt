package yocxli.flipreminder.board.list.dummy

import yocxli.flipreminder.domain.Board
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<Board> = ArrayList()

    private val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: Board) {
        ITEMS.add(item)
    }

    private fun createDummyItem(position: Int): Board {
        return Board(System.currentTimeMillis(), "Item " + position)
    }

}
