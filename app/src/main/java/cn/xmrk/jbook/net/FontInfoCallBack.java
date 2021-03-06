package cn.xmrk.jbook.net;

import com.zhy.http.okhttp.callback.Callback;

import java.util.List;

import cn.xmrk.jbook.pojo.FontBaseInfo;
import cn.xmrk.jbook.pojo.FontInfo;
import cn.xmrk.rkandroid.utils.CommonUtil;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Au61 on 2016/7/12.
 */
public abstract class FontInfoCallBack extends Callback<List<FontInfo>> {

    @Override
    public List<FontInfo> parseNetworkResponse(Response response, int id) throws Exception {
        String message = response.body().string();
        FontBaseInfo result = CommonUtil.getGson().fromJson(message, FontBaseInfo.class);
        if (result.resources != null) {//表示获取成功,然后返回一个weatherInfo
            return result.resources;
        } else {
            CommonUtil.showToast("获取数据失败");
        }
        return null;
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        //打印出exception
        e.printStackTrace();
        CommonUtil.showToast("数据获取失败");
    }
}
