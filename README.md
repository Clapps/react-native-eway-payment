
# react-native-eway-payments

## Getting started

`$ npm install react-native-eway-payments --save`

### Mostly automatic installation

`$ react-native link react-native-eway-payments`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-eway-payments` and add `RNEwayPayments.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNEwayPayments.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNEwayPaymentsPackage;` to the imports at the top of the file
  - Add `new RNEwayPaymentsPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-eway-payments'
  	project(':react-native-eway-payments').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-eway-payments/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-eway-payments')
  	```

## Usage
```javascript
import RNEwayPayments from 'react-native-eway-payments';

```
    EWayPayment.build('epk-XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX');
    EWayPayment.sandbox();

    EWayPayment.setCardDetail('Eugenio Valeiras', '1234567890123456', '01', '21', '000');
    EWayPayment.setCustomerDetail('Eugenio', 'Valeiras');
    EWayPayment.setPaymentDetail('AUD', 100, 'Invoice Description');
```

// TODO: What to do with the module?
RNEwayPayments;
```
  