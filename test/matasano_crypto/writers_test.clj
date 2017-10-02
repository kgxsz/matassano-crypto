(ns matasano-crypto.writers-test
  (:require [clojure.test :refer :all]
            [matasano-crypto.writers :as writers]))


(deftest test-write-binary-string
  (testing "it returns the corresponding binary string"
    (is (= "0010101000000001"
           (writers/write-binary-string (byte-array [(byte 42) (byte 1)])))))

  (testing "it handles negative values correctly"
    (is (= "1111111100000001"
           (writers/write-binary-string (byte-array [(byte -1) (byte 1)])))))

  (testing "it throws an assertion error when not given a byte-array"
    (is (thrown? java.lang.AssertionError (writers/write-binary-string 42)))))


