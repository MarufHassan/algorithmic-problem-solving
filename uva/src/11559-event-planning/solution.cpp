#include <cstdio>

int main()
{
    int participants, budget, hotelNumber, week, hotelCost, hotelBedNumber;
    int minimumCost;

    while(scanf("%d %d %d %d", &participants, &budget, &hotelNumber, &week) == 4)
    {
        minimumCost = 50000000;
        for(int i = 1; i <= hotelNumber; i++)
        {
            scanf("%d", &hotelCost);

            for(int j = 1; j <= week; j++)
            {
                scanf("%d", &hotelBedNumber);
                if(hotelBedNumber >= participants)
                {
                    if((hotelCost * participants) < minimumCost)
                    {
                        minimumCost = hotelCost * participants;
                    }
                }
            }
        }
        if(minimumCost <= budget)
        {
            printf("%d\n", minimumCost);
        }
        else
        {
            printf("stay home\n");
        }
    }

    return 0;
}
