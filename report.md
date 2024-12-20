# Summary of test case selection
We chose the test cases that achieved the decision coverage and MC/DC coverage in the test cases definition document because it was enough to have a coverage of 75% (28/36 * 100 = 77.78%).

![image](https://github.com/user-attachments/assets/a5b92802-1f26-4865-a20e-b9c7e072549d)

# Changes to fix errors
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
