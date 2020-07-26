# Pig-latin

## Solution

```c++
#include <iostream>
#include <cstdio>
#include <string>
using namespace std;

bool isVowel(char c)
{
    return c == 'A' || c == 'a' || c == 'E' ||
           c == 'e' || c == 'O' || c == 'o' ||
           c == 'I' || c == 'i' || c == 'U' ||
           c == 'u';
}

int main()
{
//    freopen("defaultInput.txt","r",stdin);

    string s, ax;


    while(getline(cin, s))
    {

        for(int i = 0; i < s.size(); i++)
        {
            if((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z'))
            {
                ax.push_back(s[i]);
            }
            else
            {
                if(ax.size() > 0 && isVowel(ax[0]))
                {
                    cout << ax << "ay";
                }
                else
                {
                    for(int j = 1; j < ax.size(); j++)
                    {
                        cout << ax[j];
                    }
                    if(ax.size() > 0) cout << ax[0] << "ay";
                }
                ax.clear();
                cout << s[i];
            }
        }

        if(ax.size() > 0 && isVowel(ax[0]))
        {
            cout << ax << "ay";
        }
        else
        {
            for(int j = 1; j < ax.size(); j++)
            {
                cout << ax[j];
            }
            if(ax.size() > 0) cout << ax[0] << "ay";
        }
        ax.clear();

        cout << endl;

    }

    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**