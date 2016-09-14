package com.github.keyhansoft.easyfragmentdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



public class EasyDialogFragment extends DialogFragment
{



    public interface SingleButtonCallback
    {
        void onClick(DialogInterface dialog);
    }
    public interface ListCallback
    {
        void onClick(DialogInterface dialog, int which);
    }
    public interface ListCallbackSingleChoice
    {
        void onClick(DialogInterface dialog, int which);
    }
    private static EasyDialogFragment newInstance(Bundle args)
    {
        EasyDialogFragment alertDialogFragment = new EasyDialogFragment();
        alertDialogFragment.setArguments(args);
        return alertDialogFragment;
    }

    public static class Builder implements Parcelable
    {
        protected String message;
        protected String positiveText;
        protected String negativeText;
        protected String neutralText;
        protected String[] items;
        protected String[] singleChoiceItems;
        protected View customView;
        protected Drawable icon;
        protected boolean cancelable;
        protected ListCallback itemsCallback;
        protected ListCallbackSingleChoice itemsCallbackSingleChoice;
        protected SingleButtonCallback onPositive;
        protected SingleButtonCallback onNeutral;
        protected SingleButtonCallback onNegative;
        protected SingleButtonCallback onAny;
        protected int selected;
        protected String logTag = this.getClass().getSimpleName();
        protected String title;
        protected AppCompatActivity appCompatActivity;
        protected int buttonColor = -1;

        public Builder setButtonColor(int buttonColor)
        {
            this.buttonColor = buttonColor;
            return this;
        }



        public Builder(AppCompatActivity appCompatActivity)
        {
            this.appCompatActivity = appCompatActivity;
        }

        public Builder setSingleChoiceItems(String[] singleChoiceItems)
        {
            this.singleChoiceItems = singleChoiceItems;
            return this;
        }

        public Builder setSingleChoiceItems(int resource)
        {
            this.singleChoiceItems = appCompatActivity.getResources().getStringArray(resource);
            return this;
        }

        public Builder setTitle(String title)
        {
            this.title = title;
            return this;
        }
        public Builder setTitle(int resource)
        {
            this.title = appCompatActivity.getResources().getString(resource);
            return this;
        }

        public Builder setLogTag(String logTag)
        {
            this.logTag = logTag;
            return this;
        }

        public Builder onPositive(SingleButtonCallback singleButtonCallback)
        {
            onPositive = singleButtonCallback;
            return this;
        }
        public Builder onNeutral(SingleButtonCallback singleButtonCallback)
        {
            onNeutral = singleButtonCallback;
            return this;
        }
        public Builder onNegative(SingleButtonCallback singleButtonCallback)
        {
            onNegative = singleButtonCallback;
            return this;
        }
        public Builder onAny(SingleButtonCallback singleButtonCallback)
        {
            onAny = singleButtonCallback;
            return this;
        }

        public Builder itemsCallback(ListCallback listCallback)
        {
            itemsCallback = listCallback;
            return this;
        }
        public Builder itemsCallbackSingleChoice(int selected, ListCallbackSingleChoice listCallbackSingleChoice)
        {
            itemsCallbackSingleChoice = listCallbackSingleChoice;
            this.selected = selected;
            return this;
        }

        public Builder setMessage(String message)
        {
            this.message = message;
            return this;
        }


        public Builder setMessage(int resource)
        {
            this.message = appCompatActivity.getResources().getString(resource);
            return this;
        }


        public Builder setPositiveText(String positiveText)
        {
            this.positiveText = positiveText;
            return this;
        }

        public Builder setPositiveText(int resource)
        {
            this.positiveText = appCompatActivity.getResources().getString(resource);
            return this;
        }


        public Builder setNegativeText(String negativeText)
        {
            this.negativeText = negativeText;
            return this;
        }

        public Builder setNegativeText(int resource)
        {
            this.negativeText = appCompatActivity.getResources().getString(resource);
            return this;
        }


        public Builder setNeutralTextText(String neutralText)
        {
            this.neutralText = neutralText;
            return this;
        }

        public Builder setNeutralTextText(int resource)
        {
            this.neutralText = appCompatActivity.getResources().getString(resource);
            return this;
        }


        public Builder setItems(String[] items)
        {
            this.items = items;
            return this;
        }


        public Builder setItems(int resource)
        {
            this.items = appCompatActivity.getResources().getStringArray(resource);
            return this;
        }


        public Builder setCustomView(View customView)
        {
            this.customView = customView;
            return this;
        }


        public Builder setIcon(Drawable icon)
        {
            this.icon = icon;
            return this;
        }

        public Builder setIcon(int icon)
        {
            this.icon = ContextCompat.getDrawable(appCompatActivity, icon);
            return this;
        }


        public Builder setCancelable(boolean cancelable)
        {
            this.cancelable = cancelable;
            return this;
        }

        private Bundle toBundle()
        {
            Bundle args = new Bundle();
            args.putParcelable("builder", this);

            return args;
        }
        public void show()
        {
            EasyDialogFragment.newInstance(toBundle()).show(appCompatActivity.getSupportFragmentManager(), logTag);

        }

        @Override
        public int describeContents()
        {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i)
        {

        }
    }



    @Nullable
    @Override
    public View getView()
    {
        return super.getView();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {

        final EasyDialogFragment.Builder dialogBuilder = getArguments().getParcelable("builder");
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());

        builder.setCancelable(dialogBuilder.cancelable);
        if (dialogBuilder.icon != null)
        {
            builder.setIcon(dialogBuilder.icon);
        }
        if (dialogBuilder.title != null)
        {
            builder.setTitle(dialogBuilder.title);
        }


        if (dialogBuilder.message != null && !dialogBuilder.message.isEmpty())
        {
            builder.setMessage(dialogBuilder.message);
            if(dialogBuilder.positiveText != null && !dialogBuilder.positiveText.isEmpty())
            {
                builder.setPositiveButton(dialogBuilder.positiveText, new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        if (dialogBuilder.onPositive != null)
                        {
                            dialogBuilder.onPositive.onClick(dialog);
                        }

                        if (dialogBuilder.onAny != null)
                        {
                            dialogBuilder.onAny.onClick(dialog);
                        }
                    }
                });
            }
            if(dialogBuilder.negativeText != null && !dialogBuilder.negativeText.isEmpty())
            {
                builder.setNegativeButton(dialogBuilder.negativeText, new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        if (dialogBuilder.onNegative != null)
                        {
                            dialogBuilder.onNegative.onClick(dialog);
                        }
                        if (dialogBuilder.onAny != null)
                        {
                            dialogBuilder.onAny.onClick(dialog);
                        }
                    }
                });
            }
            if(dialogBuilder.neutralText != null && !dialogBuilder.neutralText.isEmpty())
            {
                builder.setNeutralButton(dialogBuilder.neutralText, new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        if (dialogBuilder.onNeutral != null)
                        {
                            dialogBuilder.onNegative.onClick(dialog);
                        }
                        if (dialogBuilder.onAny != null)
                        {
                            dialogBuilder.onAny.onClick(dialog);
                        }
                    }
                });
            }
        }


        if(dialogBuilder.singleChoiceItems != null)
        {
            builder.setSingleChoiceItems(dialogBuilder.singleChoiceItems, dialogBuilder.selected, new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    dialogBuilder.itemsCallbackSingleChoice.onClick(dialog, which);
                }

            });
        }
        if(dialogBuilder.items != null)
        {
            builder.setItems(dialogBuilder.items, new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    dialogBuilder.itemsCallback.onClick(dialog, which);
                }

            });
        }

        if(dialogBuilder.customView != null)
        {
            builder.setView(dialogBuilder.customView);
            if(dialogBuilder.positiveText != null && !dialogBuilder.positiveText.isEmpty())
            {
                builder.setPositiveButton(dialogBuilder.positiveText, new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        if (dialogBuilder.onPositive != null)
                        {
                            dialogBuilder.onPositive.onClick(dialog);
                        }
                        if (dialogBuilder.onAny != null)
                        {
                            dialogBuilder.onAny.onClick(dialog);
                        }
                    }
                });
            }
            if(dialogBuilder.negativeText != null && !dialogBuilder.negativeText.isEmpty())
            {
                builder.setNegativeButton(dialogBuilder.negativeText, new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        if (dialogBuilder.onNegative != null)
                        {
                            dialogBuilder.onNegative.onClick(dialog);
                        }
                        if (dialogBuilder.onAny != null)
                        {
                            dialogBuilder.onAny.onClick(dialog);
                        }
                    }
                });
            }
            if(dialogBuilder.neutralText != null && !dialogBuilder.neutralText.isEmpty())
            {
                builder.setNeutralButton(dialogBuilder.neutralText, new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        if (dialogBuilder.onNeutral != null)
                        {
                            dialogBuilder.onNegative.onClick(dialog);
                        }
                        if (dialogBuilder.onAny != null)
                        {
                            dialogBuilder.onAny.onClick(dialog);
                        }
                    }
                });
            }
        }


        AlertDialog dialog = builder.create();
        if(dialogBuilder.buttonColor != -1)
        {
            dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(dialogBuilder.buttonColor);
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(dialogBuilder.buttonColor);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(dialogBuilder.buttonColor);
        }
        return dialog;
    }

}