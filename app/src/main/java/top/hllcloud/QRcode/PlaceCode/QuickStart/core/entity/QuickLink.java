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

package top.hllcloud.QRcode.PlaceCode.QuickStart.core.entity;

import android.content.Intent;
import android.net.Uri;

import com.xuexiang.xutil.app.ActivityUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import top.hllcloud.QRcode.PlaceCode.QuickStart.core.enums.OpenType;

public class QuickLink {

    private String title;
    private String link;
    private OpenType openType;
    private Integer sort = 100;
    private Date addTime;

    public QuickLink() {
    }

    public QuickLink(String title, String link, OpenType openType, Integer sort, Date addTime) {
        this.title = title;
        this.link = link;
        this.openType = openType;
        this.sort = sort;
        this.addTime = addTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public OpenType getOpenType() {
        return openType;
    }

    public void setOpenType(OpenType openType) {
        this.openType = openType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
