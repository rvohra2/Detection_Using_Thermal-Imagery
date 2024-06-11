#android studio
#background service



package dic.uiet.pu.chd.thermaldata;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutionException;

public class ThermalBackgroundService extends Service
{
    static String PHP_URL = "";
    static String lastFileName = "";
    Handler handler;
    Runnable runnable;
    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show();
        PHP_URL = intent.getStringExtra("PHP_URL");
        return Service.START_STICKY_COMPATIBILITY;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        handler = new Handler();
        runnable = new Runnable()
        {
            public void run()
            {
                File lastModifiedFile = lastFileModified(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/FLIROne");
                String lastModifiedFileName = lastModifiedFile.getName();
                if(!lastFileName.equals(lastModifiedFileName))
                {
                    try
                    {
                        int serverCode = new UploadFile().execute(lastModifiedFile.getAbsolutePath(),PHP_URL).get();
                    } catch (InterruptedException | ExecutionException e)
                    {
                        e.printStackTrace();
                    }
                    lastFileName = lastModifiedFileName;
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Same file encountered", Toast.LENGTH_SHORT).show();
                }
                handler.postDelayed(this, 5000);
            }
        };
        handler.postDelayed(runnable, 5000);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
        Toast.makeText(this, "Service stopped", Toast.LENGTH_SHORT).show();
    }

    public static File lastFileModified(String dir)
    {
        File fl = new File(dir);
        File[] files = fl.listFiles(new FileFilter()
        {
            public boolean accept(File file)
            {
                return file.isFile();
            }
        });
        long lastMod = Long.MIN_VALUE;
        File choice = null;
        for (File file : files)
        {
            if (file.lastModified() > lastMod)
            {
                choice = file;
                lastMod = file.lastModified();
            }
        }
        return choice;
    }
}
