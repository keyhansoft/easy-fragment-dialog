# easy-fragment-dialog
```gradle
allprojects {  
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}

dependencies {
	compile 'com.github.keyhansoft:easy-fragment-dialog:-SNAPSHOT'
}

new EasyDialogFragment.Builder(AdShowActivity.this)
        .setCustomView(v)
        .setPositiveText(R.string.ok)
        .setNegativeText(R.string.cancel)
        .setButtonColor(ContextCompat.getColor(AdShowActivity.this, R.color.primary))
        .onPositive(new EasyDialogFragment.SingleButtonCallback()
        {
            @Override
            public void onClick(DialogInterface dialogInterface)
            {

            }
        })
        .onNegative(new EasyDialogFragment.SingleButtonCallback()
        {
            @Override
            public void onClick(DialogInterface dialogInterface)
            {

            }
        }).show(); 
