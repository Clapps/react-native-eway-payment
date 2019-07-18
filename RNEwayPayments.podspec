
Pod::Spec.new do |s|
  s.name         = "RNEwayPayments"
  s.version      = "1.0.0"
  s.summary      = "RNEwayPayments"
  s.description  = <<-DESC
                  RNEwayPayments
                   DESC
  s.homepage     = ""
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/RNEwayPayments.git", :tag => "master" }
  s.source_files  = "RNEwayPayments/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  s.dependency "eWAYPaymentsSDK"
  #s.dependency "others"

end

  