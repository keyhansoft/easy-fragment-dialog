package com.github.keyhansoft.easyfragmentdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;


public class EasyDialogFragment extends DialogFragment
{


    private static EasyDialogFragment newInstance(Bundle args)
    {
        EasyDialogFragment alertDialogFragment = new EasyDialogFragment();
        alertDialogFragment.setArguments(args);
        return alertDialogFragment;
    }

    @Override
    public View getView()
    {
        return super.getView();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {

        final EasyDialogFragment.Builder dialogBuilder = getArguments().getParcelable("builder");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setCancelable(dialogBuilder.cancelable);
        if (dialogBuilder.icon != null)
        {
            builder.setIcon(dialogBuilder.icon);
        }
        if (dialogBuilder.title != null)
        {
            builder.setTitle(dialogBuilder.title);

        }

        builder.setOnKeyListener(new DialogInterface.OnKeyListener()
        {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent)
            {
                if (i == KeyEvent.KEYCODE_BACK)
                {
                    getActivity().finish();
                }
                return false;
            }
        });


        if (dialogBuilder.message != null && !dialogBuilder.message.isEmpty())
        {
            builder.setMessage(dialogBuilder.message);
            if (dialogBuilder.positiveText != null && !dialogBuilder.positiveText.isEmpty())
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
            if (dialogBuilder.negativeText != null && !dialogBuilder.negativeText.isEmpty())
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
            if (dialogBuilder.neutralText != null && !dialogBuilder.neutralText.isEmpty())
            {
                builder.setNeutralButton(dialogBuilder.neutralText, new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        if (dialogBuilder.onNeutral != null)
                        {
                            dialogBuilder.onNeutral.onClick(dialog);
                        }
                        if (dialogBuilder.onAny != null)
                        {
                            dialogBuilder.onAny.onClick(dialog);
                        }
                    }
                });
            }
        }


        if (dialogBuilder.singleChoiceItems != null)
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
        if (dialogBuilder.items != null)
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

        if (dialogBuilder.customView != null)
        {
            builder.setView(dialogBuilder.customView);
            if (dialogBuilder.positiveText != null && !dialogBuilder.positiveText.isEmpty())
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
            if (dialogBuilder.negativeText != null && !dialogBuilder.negativeText.isEmpty())
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
            if (dialogBuilder.neutralText != null && !dialogBuilder.neutralText.isEmpty())
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
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnShowListener(new DialogInterface.OnShowListener()
        {
            @Override
            public void onShow(DialogInterface dialogInterface)
            {
                try
                {
                    if (dialogBuilder.buttonColor != -1)
                    {
                        if (((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_POSITIVE) != null)
                        {
                            ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(dialogBuilder.buttonColor);
                            if (dialogBuilder.buttonsTypeface != null)
                            {
                                ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_POSITIVE).setTypeface(dialogBuilder.buttonsTypeface);
                            }
                        }
                        if (((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_NEGATIVE) != null)
                        {
                            ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(dialogBuilder.buttonColor);
                            if (dialogBuilder.buttonsTypeface != null)
                            {
                                ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_NEGATIVE).setTypeface(dialogBuilder.buttonsTypeface);
                            }
                        }
                        if (((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_NEUTRAL) != null)
                        {
                            ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(dialogBuilder.buttonColor);
                            if (dialogBuilder.buttonsTypeface != null)
                            {
                                ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_NEUTRAL).setTypeface(dialogBuilder.buttonsTypeface);
                            }
                        }
                    }

                    ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_NEUTRAL).setTypeface(dialogBuilder.buttonsTypeface);


                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        return dialog;
    }

    @Override
    public void onStart()
    {
        super.onStart();
        final EasyDialogFragment.Builder dialogBuilder = getArguments().getParcelable("builder");
        if ((getDialog()) != null && dialogBuilder != null && !dialogBuilder.autoDismiss)
        {
            if (((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_POSITIVE) != null)
            {
                ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        if (dialogBuilder.onPositive != null)
                        {
                            dialogBuilder.onPositive.onClick(getDialog());
                        }
                        if (dialogBuilder.onAny != null)
                        {
                            dialogBuilder.onAny.onClick(getDialog());
                        }
                    }
                });
            }
            if (((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_NEGATIVE) != null)
            {
                ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        if (dialogBuilder.onNegative != null)
                        {
                            dialogBuilder.onNegative.onClick(getDialog());
                        }
                        if (dialogBuilder.onAny != null)
                        {
                            dialogBuilder.onAny.onClick(getDialog());
                        }
                    }
                });
            }
            if (((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_NEUTRAL) != null)
            {
                ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_NEUTRAL).setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        if (dialogBuilder.onNeutral != null)
                        {
                            dialogBuilder.onNeutral.onClick(getDialog());
                        }
                        if (dialogBuilder.onAny != null)
                        {
                            dialogBuilder.onAny.onClick(getDialog());
                        }
                    }
                });
            }
        }
    }

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

    public static class Builder implements Parcelable
    {
        public static final Creator<Builder> CREATOR = new Creator<Builder>()
        {
            @Override
            public Builder createFromParcel(Parcel in)
            {
                return new Builder(in);
            }

            @Override
            public Builder[] newArray(int size)
            {
                return new Builder[size];
            }
        };
        SingleButtonCallback onPositive;
        boolean autoDismiss = true;
        String message;
        String positiveText;
        String negativeText;
        String neutralText;
        String[] items;
        String[] singleChoiceItems;
        View customView;
        Drawable icon;
        boolean cancelable;
        ListCallback itemsCallback;
        ListCallbackSingleChoice itemsCallbackSingleChoice;
        SingleButtonCallback onNeutral;
        SingleButtonCallback onNegative;
        SingleButtonCallback onAny;
        int selected;
        String logTag = this.getClass().getSimpleName();
        String title;
        AppCompatActivity appCompatActivity;
        int buttonColor = -1;
        Typeface buttonsTypeface;

        public Builder(AppCompatActivity appCompatActivity)
        {
            this.appCompatActivity = appCompatActivity;
        }

        protected Builder(Parcel in)
        {
            autoDismiss = in.readByte() != 0;
            message = in.readString();
            positiveText = in.readString();
            negativeText = in.readString();
            neutralText = in.readString();
            items = in.createStringArray();
            singleChoiceItems = in.createStringArray();
            cancelable = in.readByte() != 0;
            selected = in.readInt();
            logTag = in.readString();
            title = in.readString();
            buttonColor = in.readInt();
        }

        public Builder setButtonColor(int buttonColor)
        {
            this.buttonColor = buttonColor;
            return this;
        }

        public Builder setAutoDismiss(boolean autoDismiss)
        {
            this.autoDismiss = autoDismiss;
            return this;
        }

        public Builder setButtonsTypeFace(Typeface typeFace)
        {
            this.buttonsTypeface = typeFace;
            return this;
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
            parcel.writeByte((byte) (autoDismiss ? 1 : 0));
            parcel.writeString(message);
            parcel.writeString(positiveText);
            parcel.writeString(negativeText);
            parcel.writeString(neutralText);
            parcel.writeStringArray(items);
            parcel.writeStringArray(singleChoiceItems);
            parcel.writeByte((byte) (cancelable ? 1 : 0));
            parcel.writeInt(selected);
            parcel.writeString(logTag);
            parcel.writeString(title);
            parcel.writeInt(buttonColor);
        }
    }
}
