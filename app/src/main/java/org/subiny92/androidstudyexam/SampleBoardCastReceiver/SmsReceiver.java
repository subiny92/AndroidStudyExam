package org.subiny92.androidstudyexam.SampleBoardCastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsReceiver extends BroadcastReceiver {

    private static final String TAG = "BroadcastReceiver";
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive()");

        Bundle bundle = intent.getExtras();
        SmsMessage [] smsMessages = parseMessage(bundle);
        if (smsMessages != null && smsMessages.length > 0) {
            /// SMS 발신 번호 가져옴.
            String sender = smsMessages[0].getOriginatingAddress();
            Log.d(TAG, "SMS sender : " + sender);

            /// SMS 메세지 확인
            String contents = smsMessages[0].getMessageBody();
            Log.d(TAG, "SMS Contents : " + contents);

            /// SMS 수신 시간 확인
            Date date = new Date(smsMessages[0].getTimestampMillis());
            Log.d(TAG, "SMS received date : " + date.toString());

            startToActivity(context, sender, contents, date);
        }

    }

    private void startToActivity(Context context, String sender, String contents, Date date) {
        Intent intent = new Intent(context, BoardCastReceiverActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
            Intent.FLAG_ACTIVITY_SINGLE_TOP |
            Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("sender", sender);
        intent.putExtra("message", contents);
        intent.putExtra("date", format.format(date));

        context.startActivity(intent);
    }

    private SmsMessage[] parseMessage(Bundle bundle) {

        Object [] objects = (Object []) bundle.get("pdus");
        SmsMessage [] smsMessages = new SmsMessage[objects.length];

        int smsCount = smsMessages.length;
        for (int i = 0; i < smsCount; i++) {

            String format = bundle.getString("format");
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                smsMessages [i] = SmsMessage.createFromPdu((byte[]) objects[i], format);
            }
            else {
                smsMessages[i] = SmsMessage.createFromPdu((byte[]) objects[i]);
            }
        }

        return smsMessages;
    }
}
