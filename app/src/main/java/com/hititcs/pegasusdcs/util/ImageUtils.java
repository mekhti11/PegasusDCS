package com.hititcs.pegasusdcs.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import com.hititcs.pegasusdcs.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

import timber.log.Timber;

public class ImageUtils {

  private ImageUtils(){

  }

  public static Drawable loadImageUriAsDrawable(Context context, Uri uri){
    try {
      InputStream inputStream = context.getContentResolver().openInputStream(uri);
      return Drawable.createFromStream(inputStream, uri.toString());
    } catch (FileNotFoundException e) {
      Timber.e(e);
      return context.getResources().getDrawable(R.drawable.ic_logo_pgs);
    }
  }

}
