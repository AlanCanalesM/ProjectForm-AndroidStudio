package com.example.myapplication.contenedores;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Fragments1_sem.FlecFragment;
import com.example.myapplication.Fragments1_sem.VideoslecFragment;
import com.example.myapplication.GreenFragment;
import com.example.myapplication.QuimicaFragment;
import com.example.myapplication.R;
import com.example.myapplication.RedFragment;
import com.example.myapplication.adapters.SeccionesAdapter;
import com.example.myapplication.clases.Utilidades;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContenedorFragment3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContenedorFragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContenedorFragment3 extends Fragment {




    private OnFragmentInteractionListener mListener;

    View vista;
    private AppBarLayout appBar;
    private TabLayout pestanas;
    private ViewPager viewPager;

    public ContenedorFragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContenedorFragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static ContenedorFragment3 newInstance(String param1, String param2) {
        ContenedorFragment3 fragment = new ContenedorFragment3();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        vista=inflater.inflate(R.layout.fragment_contenedor_fragment3, container, false);
        if (Utilidades.rotacion==0){

            View parent = (View) container.getParent();
            if (appBar==null){

                appBar=(AppBarLayout) parent.findViewById(R.id.appBar);
                pestanas=new TabLayout(getActivity());
                pestanas.setTabTextColors(Color.parseColor("#0A1756"), Color.parseColor("#0A1756"));
                appBar.addView(pestanas);

                viewPager= (ViewPager) vista.findViewById(R.id.idViewPagerInformacion3);

                llenarViewPager(viewPager);
                viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){

                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }
                });

                pestanas.setupWithViewPager(viewPager);
            }
            pestanas.setTabGravity(TabLayout.GRAVITY_FILL);
        }else {
            Utilidades.rotacion=1;
        }

        return vista;
    }

    private void llenarViewPager(ViewPager viewPager) {

        SeccionesAdapter adapter=new SeccionesAdapter(getFragmentManager());
        adapter.addFragment(new GreenFragment(), "TEORIA");
        adapter.addFragment(new VideoslecFragment(), "VIDEOS");
        adapter.addFragment(new FlecFragment(), "FORMULAS");

        viewPager.setAdapter(adapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (Utilidades.rotacion==0){
            appBar.removeView(pestanas);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
