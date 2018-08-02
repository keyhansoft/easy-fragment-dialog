# easy-fragment-dialog
```gradle
allprojects {  
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}

dependencies {
	implementation 'com.github.keyhansoft:easy-fragment-dialog:2.0'
}
```

```
new EasyDialogFragment.Builder(this)
	.setCustomView(v)
	.setButtonsTypeFace(FontUtils.getTypeFace())
	.setPositiveText(R.string.ok)
	.setNegativeText(R.string.cancel)
	.setButtonColor(ContextCompat.getColor(this, R.color.primary))
	.onPositive(new EasyDialogFragment.SingleButtonCallback()
	{
	    @Override
	    public void onClick(DialogInterface dialogInterface)
	    {
	        Snackbar.make(findViewById(android.R.id.content), R.string.message, Snackbar.LENGTH_LONG)
	                .setAction(R.string.ok, new View.OnClickListener()
	                {
	                    @Override
	                    public void onClick(View view)
	                    {
	
	                    }
	                })
	                .setActionTextColor(getResources().getColor(R.color.secondary))
	                .setDuration(2000)
	                .show();
	    }
	})
	.onNegative(new EasyDialogFragment.SingleButtonCallback()
	{
	    @Override
	    public void onClick(DialogInterface dialogInterface)
	    {
	
	    }
	}).show();
