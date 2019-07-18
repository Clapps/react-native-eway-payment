Pod::Spec.new do |s|
  s.name         = "RNEwayPayments"
  s.summary = "RN Bridge module for eway payments"
  s.version = "0.0.3"

  s.description  = <<-DESC
                  RNEwayPayments
                   DESC
  s.homepage       = "https://github.com/Clapps/react-native-eway-payments"
  s.source        = { :git => "https://github.com/Clapps/react-native-eway-payments.git", :branch => "master" }
  s.source_files  = "ios/**/*.{h,m}"
  s.author        = { "author" => "clapps" }
  s.platform     = :ios, "9.0"
  s.requires_arc = true

  s.dependency "React"
  s.dependency "eWAYPaymentsSDK"
  #s.dependency "others"

end