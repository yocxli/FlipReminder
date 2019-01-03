package yocxli.flipreminder

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import yocxli.flipreminder.board.list.BoardFragment
import yocxli.flipreminder.settings.SettingsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var boardFragment: BoardFragment

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    openBoardList()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    openDashboard()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    openNotification()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boardFragment = BoardFragment.newInstance(2)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_actions, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
            openSettings()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun openBoardList() {
        supportFragmentManager.beginTransaction().replace(R.id.content, boardFragment)
            .show(boardFragment).commit()
    }

    private fun openDashboard() {
        Toast.makeText(this, "Dashboard", Toast.LENGTH_SHORT).show()
        supportFragmentManager.beginTransaction().hide(boardFragment).commit()
    }

    private fun openNotification() {
        Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show()
        supportFragmentManager.beginTransaction().hide(boardFragment).commit()
    }

    private fun openSettings() {
        startActivity(Intent(this, SettingsActivity::class.java))
    }
}
