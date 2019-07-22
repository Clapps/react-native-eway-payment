require 'json'
package = JSON.parse(File.read('./package.json'))

Pod::Spec.new do |s|
  s.name                = "RNEwayPayments"
  s.version             = package["version"]
  s.summary             = package["description"]
  s.description  = <<-DESC
                  RNEwayPayments
                   DESC
  s.homepage     = "https://github.com/Clapps/react-native-eway-payments"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/Clapps/react-native-eway-payments", :tag => "master" }
  s.source_files  = "RNEwayPayments/**/*.{h,m}"
  s.requires_arc = true

  s.dependency "React/Core"
  s.dependency "eWAYPaymentsSDK"
end
