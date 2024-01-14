// Write C++ code here.
//
// Do not forget to dynamically load the C++ library into your application.
//
// For instance,
//
// In MainActivity.java:
//    static {
//       System.loadLibrary("helloworld");
//    }
//
// Or, in MainActivity.kt:
//    companion object {
//      init {
//         System.loadLibrary("helloworld")
//      }
//    }

#include <string>
#include <assert.h>
#include <vector>
#include <jni.h>

using namespace std;
std::vector<std::string> split(const std::string& s) {
    std::vector<std::string> ret;
    if (s.length() == 0) return ret;
    // bracket
    if (s.at(0) == '(') {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.at(i) == '(') cnt++;
            else if (s.at(i) == ')') cnt--;
            if (cnt == 0) {
                ret.push_back(s.substr(0, i + 1));
                auto r = split(s.substr(i + 1));
                std::copy(r.begin(), r.end(), std::back_inserter(ret));
                break;
            }
        }
    }
    else if (('0' <= s.at(0) && s.at(0) <= '9') || s.at(0) == '.') {
        ret.push_back("");
        for (int i = 0; i < s.length(); i++) {
            if (('0' <= s.at(i) && s.at(i) <= '9') || s.at(i) == '.')
                ret.back() += s.at(i);
            else {
                auto r = split(s.substr(i));
                std::copy(r.begin(), r.end(), std::back_inserter(ret));
                break;
            }
        }
    }
    else {
        ret.push_back(s.substr(0, 1));
        auto r = split(s.substr(1));
        std::copy(r.begin(), r.end(), std::back_inserter(ret));
    }
    return ret;
}


double Java_com_example_helloworld_crawl_calc(std::string s) {
    auto parts = split(s);
    if (parts.size() == 0)
        return 0;
    if (parts.size() == 1) {
        if (s.at(0) == '(')
            return Java_com_example_helloworld_crawl_calc(s.substr(1, s.length() - 2));
        else {
            assert(('0' <= s.at(0) && s.at(0) <= '9') || s.at(0) == '.');
            return std::stod(s);
        }
    }
    double ret = Java_com_example_helloworld_crawl_calc(parts.at(0));
    for (int i = 1; i < parts.size(); i += 2) {
        assert(i + 1 < parts.size());
        if (parts.at(i) == "+")
            ret += Java_com_example_helloworld_crawl_calc(parts.at(i + 1));
        else if (parts.at(i) == "-")
            ret -= Java_com_example_helloworld_crawl_calc(parts.at(i + 1));
        else
            assert(false);
    }
    return ret;
}