/*
 * Copyright (C) 2022 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package top.hllcloud.QRcode.PlaceCode.QuickStart.core.fragment;

import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;

import com.umeng.analytics.MobclickAgent;
import com.xuexiang.xaop.annotation.Permission;
import com.xuexiang.xaop.annotation.SingleClick;
import com.xuexiang.xaop.consts.PermissionConsts;
import com.xuexiang.xpage.base.XPageContainerListFragment;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.xuexiang.xui.widget.actionbar.TitleUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import top.hllcloud.QRcode.PlaceCode.QuickStart.core.adapter.QuickLinkListAdapter;
import top.hllcloud.QRcode.PlaceCode.QuickStart.core.entity.QuickLink;
import top.hllcloud.QRcode.PlaceCode.QuickStart.core.enums.OpenType;
import top.hllcloud.QRcode.PlaceCode.QuickStart.utils.Utils;

/**
 * 快捷连接列表容器
 *
 * @author xuexiang
 * @since 2018/11/22 上午11:26
 */
public abstract class LinkListContainerFragment extends XPageContainerListFragment {

    List<QuickLink> quickLinks = new ArrayList<>();

    @Override
    protected void initPage() {
        initTitle();
        initViews();
        initListeners();
    }

    protected TitleBar initTitle() {
        return TitleUtils.addTitleBarDynamic((ViewGroup) getRootView(), getPageTitle(), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popToBack();
            }
        });
    }

    @Override
    protected void initData() {
        quickLinks.add(new QuickLink("新芒果一号楼", "https://safetrip.zhengzhou.gov.cn:20021/mobile/index.html?sqid=202204290024334067&lx=13&orgid=1500", OpenType.ALIPAY, 1, new Date()));
        quickLinks.add(new QuickLink("润德大厦", "https://safetrip.zhengzhou.gov.cn:20021/mobile/index.html?sqid=202204290024386822&lx=13&orgid=1500", OpenType.ALIPAY, 4, new Date()));
        quickLinks.add(new QuickLink("大学科技园北门", "https://safetrip.zhengzhou.gov.cn:20021/mobile/index.html?sqid=202204290024102493&lx=8&orgid=800", OpenType.ALIPAY, 2, new Date()));
        quickLinks.add(new QuickLink("大学科技园孵化一号楼", "https://safetrip.zhengzhou.gov.cn:20021/mobile/index.html?sqid=202204290023740120&lx=8&orgid=800", OpenType.ALIPAY, 3, new Date()));

        getListView().setAdapter(new QuickLinkListAdapter(getContext(), quickLinks));
        initSimply();
    }

    @Permission({PermissionConsts.STORAGE})
    private void loadConfig() {

    }

    @Override
    public void onItemClick(int position) {
        Utils.openLink(this.getContext(), quickLinks.get(position));
    }

    @SingleClick
    private void onItemClick(View view, int position) {
        onItemClick(position);
    }

    @Override
    public void onDestroyView() {
        getListView().setOnItemClickListener(null);
        super.onDestroyView();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //屏幕旋转时刷新一下title
        super.onConfigurationChanged(newConfig);
        ViewGroup root = (ViewGroup) getRootView();
        if (root.getChildAt(0) instanceof TitleBar) {
            root.removeViewAt(0);
            initTitle();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(getPageName());
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(getPageName());
    }
}
