package edu.gatech.gtorg.gitmad.threads.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import edu.gatech.gtorg.gitmad.threads.R;

public class ThreadsListFragment extends Fragment {

    private static final String KEY_THREAD_NAMES = "thread names key";


    private OnThreadClickedListener clickListener;
    private String[] threadNames;





    /*
        public default constructor necessary for the Android OS to manage
        the application's state. See
        http://stackoverflow.com/questions/25984054/android-fragments-is-empty-constructor-really-required
     */
    public ThreadsListFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (getActivity() instanceof OnThreadClickedListener) {
            clickListener = (OnThreadClickedListener) getActivity();

        } else {
            throw new ClassCastException("Activity that contains Fragment ThreadsListFragment must implement OnThreadClickedListener in order to receive click events");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        threadNames = getActivity().getResources().getStringArray(R.array.thread_names);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_threads_list, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.threadsListView);

        addListAdapter(listView);

        addListClickListener(listView);

        return rootView;
    }

    private void addListAdapter(ListView listView) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, threadNames);
        listView.setAdapter(adapter);
    }

    private void addListClickListener(ListView listView) {
        /* TODO 5
         *
         * Set an OnItemClickListener for listView so it can take you to the appropriate thread
         * description.
         *
         * Hint: You need to give the listView listener a new AdapterView.OnItemClickListener and override
         * the AdapterView.OnItemClickListener's onItemClick(...) method.
         *
         * https://developer.android.com/reference/android/widget/AdapterView.OnItemClickListener.html
         *
         * Inside the onItemClick(), call clickListener's threadClicked() method (defined in the interface below)
         * We need a threadName and threadIndex. If only there were a String[] in this file with all the threads and
         * a variable that corresponded to the position in the array...
         */


    }

    public interface OnThreadClickedListener {
        public void threadClicked(String threadName, int threadIndex);
    }
}
