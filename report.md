## before_patch0 -> before_patch1
### ActivityRecommendation.java changes:
* In line 25, the condition `weather.getTemperature() > 25` was added to better fit the requirements and a test was failing for that.

### ActivityRecommendationTest.java changes:
* In testDecisionMCDC1, the temperature was changed from 10 to 40.
* In testDecisionMCDC2, the precipitation was changed from false to true in both test cases.
* In testDecisionMCDC3, the precipitation had the same change in test case 7.

## before_patch1 -> before_patch2
### ActivityRecommendationTest.java changes:
* In testDecisionMCDC3, the expected output changed from "Go skiing." to "No specific recommendation." in test case 7 because the test case definition had a practical error.
* In testDecisionMCDC7, the temperature changed from 20 to 10 in test case 19 because there was a typo in the test case defintion.

## before_patch2 -> after (main)
### ActivityRecommendationTest.java changes:
* In testDecisionMCDC7, the expected output changed from "No specific recommendation." to "Go hiking." in test case 19 as a consequence to the last change of temperature.
