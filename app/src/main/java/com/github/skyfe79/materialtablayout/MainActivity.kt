package com.github.skyfe79.materialtablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toDrawable
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    private lateinit var tabType: TabType

    companion object {
        val TAB_TYPE = "tab_type"
        private val tabArray = arrayOf(
            "Home",
            "Chat",
            "Profile")//Tab title array
        private val tabIcons = arrayOf(
            R.drawable.ic_home_white_24dp,
            R.drawable.ic_chat_white_24dp,
            R.drawable.ic_account_box_white_24dp)//Tab icons array
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabType = intent?.getSerializableExtra(TAB_TYPE) as? TabType ?: TabType.DEFAULT

        setSupportActionBar(toolbar)
        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) = Unit
            override fun onTabSelected(tab: TabLayout.Tab?) = Unit
        })

        onTabType()
    }

    private fun onTabType() {
        when (tabType) {
            TabType.DEFAULT -> Unit
            TabType.ICON_TEXT, TabType.ICONS_ONLY -> tabWithIcon()
            TabType.CUSTOM -> setupCustomTabs()
        }
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager, tabType)
        tabArray.forEach {
            adapter.addFragment(DemoFragment.newInstance(it), it)
        }
        viewPager.adapter = adapter
    }

    private fun tabWithIcon() {
        (0 until tabIcons.size).forEach { index ->
            val tab = tabLayout.getTabAt(index)
            tab?.let {
                tab.icon = ContextCompat.getDrawable(this@MainActivity, tabIcons[index])
            }
        }
    }

    private fun setupCustomTabs() {
        (0 until tabArray.size).forEach { index ->
            val customTab = layoutInflater.inflate(R.layout.custom_tab_layout, null) as? TextView
            customTab?.text = tabArray[index]
            customTab?.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[index], 0, 0)
            val tab = tabLayout.getTabAt(index)
            tab?.customView = customTab
        }
    }
}
