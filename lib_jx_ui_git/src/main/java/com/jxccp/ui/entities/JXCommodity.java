/**
 * Copyright (C) 2015-2016 Guangzhou Xunhong Network Technology Co., Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jxccp.ui.entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class JXCommodity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品标题
     */
    public String title;

    /**
     * 图片路径
     */
    public String path;

    /**
     * 商品显示内容
     */
    public String content;

    /**
     * 资源id
     */
    public int resId;
    
    /**
     * 商品链接
     */
    public String url;
    
    public JXCommodity(){
        
    }
    
    public JXCommodity(int resId){
        this.resId = resId;
    }

    public void saveImage(Context context) {
        try {
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resId);
            path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/jiaxin"
                    + File.separator + resId + ".png";
            File file = new File(path);
            if (file.exists()) {
                return;
            }
            String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/jiaxin";
            File createDir = new File(dir);
            if (!createDir.exists()) {
                createDir.mkdir();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
            FileOutputStream fOut = null;
            try {
                fOut = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (bitmap != null && fOut != null) {
                Boolean isSave = bitmap.compress(Bitmap.CompressFormat.PNG, 80, fOut);
                try {
                    fOut.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof JXCommodity)) {
            return false;
        }
        return resId==((JXCommodity) o).resId;
    }
}
