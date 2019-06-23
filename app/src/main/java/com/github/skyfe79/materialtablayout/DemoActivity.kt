package com.github.skyfe79.materialtablayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

enum class TabType {
    DEFAULT,
    ICON_TEXT,
    ICONS_ONLY,
    CUSTOM
}

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
    }

    fun showDefaultTab(sender: View) {
        startTabActivity(TabType.DEFAULT)
    }

    fun showTabWithIconAndText(sender: View) {
        startTabActivity(TabType.ICON_TEXT)
    }

    fun showTabWithIconsOnly(sender: View) {
        startTabActivity(TabType.ICONS_ONLY)
    }

    fun showCustomTab(sender: View) {
        startTabActivity(TabType.CUSTOM)
    }

    private fun startTabActivity(tabType: TabType) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(MainActivity.TAB_TYPE, tabType)
        startActivity(intent)
    }
}
