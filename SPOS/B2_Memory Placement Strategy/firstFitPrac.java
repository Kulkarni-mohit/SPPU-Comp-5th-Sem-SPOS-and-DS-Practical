// https://www.youtube.com/watch?v=RZ6674-mjrQ

public class firstFitPrac {

    static void firstFit(int[] blockSize, int m, int [] processSize, int n){
        int Allocated[] = new int[n];

        for(int i=0; i<n;i++){
            Allocated[i] = -1;
        }

        for (int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if (blockSize[j]>processSize[i]){
                    Allocated[i] = j;
                    blockSize[j]-=processSize[i];
                    break;
                }
            }
        }

        for(int i=0; i<n;i++){
            System.out.print((i+1)+"\t"+ processSize[i]+ "\t"+ Allocated[i]);
            // if(Allocated[i]!=-1)
            //     System.out.print(Allocated[i]);
            // else
            //     System.out.print("Not Allocated");
            System.out.println();
        }

    }

    static void bestFit(int[] blockSize, int m, int [] processSize, int n){
        int Allocated[] = new int[n];

        for(int i=0; i<n;i++){
            Allocated[i] = -1;
        }

        for(int i=0; i<n; i++){
            int maxidx = -1;

            for(int j=0; j<m; j++){
                if(blockSize[j]>processSize[i]){
                    if(maxidx==-1)
                        maxidx=j;
                    else if(blockSize[maxidx]> blockSize[j])
                        maxidx=j;
                }
            }

            if (maxidx!=-1){
                Allocated[i] = maxidx;
                blockSize[maxidx]-=processSize[i];
            }
        }

        for(int i=0; i<n;i++){
            System.out.print((i+1)+"\t"+ processSize[i]+ "\t");
            if(Allocated[i]!=-1)
                System.out.print(Allocated[i]);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }
        
    }


    static void worstFit(int[] blockSize, int m, int [] processSize, int n){
        int Allocated[] = new int[n];

        for(int i=0; i<n;i++){
            Allocated[i] = -1;
        }

        for(int i=0; i<n; i++){
            int maxidx = -1;

            for(int j=0; j<m; j++){
                if(blockSize[j]>processSize[i]){
                    if(maxidx==-1)
                        maxidx=j;
                    else if(blockSize[maxidx]< blockSize[j])
                        maxidx=j;
                }
            }

            if (maxidx!=-1){
                Allocated[i] = maxidx;
                blockSize[maxidx]-=processSize[i];
            }
        }

        for(int i=0; i<n;i++){
            System.out.print((i+1)+"\t"+ processSize[i]+ "\t");
            if(Allocated[i]!=-1)
                System.out.print(Allocated[i]);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }
        
    }

    public static void main(String[] Args){
        int blockSize[] = {100, 500, 200, 300, 600};
        int processSize[] = {212, 417, 112, 426};
        int m = blockSize.length;
        int n = processSize.length;

        firstFit(blockSize, m, processSize, n);
    }
}
