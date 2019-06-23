package com.github.skyfe79.materialtablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(
    fragmentManger: FragmentManager,
    private val tabType: TabType
): FragmentPagerAdapter(fragmentManger) {

    private val fragmentList = mutableListOf<Fragment>()
    private val titleList = mutableListOf<String>()


    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        titleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if (tabType == TabType.ICONS_ONLY) {
            return ""
        }
        return titleList[position]
    }
}