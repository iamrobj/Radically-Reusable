package com.robj.radicallyreusable.base.mvp;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

/**
 * Created by Rob J on 31/01/17.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    protected Context getContext() {
        return itemView.getContext();
    }

}
