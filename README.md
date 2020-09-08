# ActivityResultCallbackUtil

## Code
```
     // click listener
     binding.requestButton.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            activityResultHelper.addActResultObserver(intent, Main2Activity.REQUEST_CODE) { resultCode, data ->
               //확인 후 
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val resultText = data.getStringExtra(Main2Activity.KEY_RESULT_TEXT)
                    binding.resultText.text = resultText
                }
            }
     }
    
```


### todo
1. courutine
