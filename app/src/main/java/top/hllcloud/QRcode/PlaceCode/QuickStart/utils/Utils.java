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

package top.hllcloud.QRcode.PlaceCode.QuickStart.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import org.jetbrains.annotations.NotNull;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import top.hllcloud.QRcode.PlaceCode.QuickStart.core.entity.QuickLink;

public class Utils {

    public static void openLink(@NotNull Context context, @NotNull QuickLink quickLink) {
        try {
            String link = URLEncoder.encode(quickLink.getLink(), "UTF-8");
            String url = quickLink.getOpenType().getPrefix() + link;
            Uri uri = Uri.parse(url); // url为你要链接的地址
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
            XToastUtils.success("跳转成功!");
        } catch (UnsupportedEncodingException e) {
            XToastUtils.error("跳转失败!");
        }
    }
}
