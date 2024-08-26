package com.example.yourapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import android.widget.ArrayAdapter

class EmployeeExpectationsFragment : Fragment() {

    private lateinit var listViewExpectations: ListView
    private lateinit var textViewExpectations: TextView

    private lateinit var viewModel: EmployeeViewModel
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_employee_expectations, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(EmployeeViewModel::class.java)

        // Initialize Views
        listViewExpectations = view.findViewById(R.id.listViewExpectations)
        textViewExpectations = view.findViewById(R.id.textViewExpectations)

        // Setup ListView Adapter
        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, mutableListOf<String>())
        listViewExpectations.adapter = adapter

        // Observe the employee list and update the ListView with expectations
        viewModel.employees.observe(viewLifecycleOwner, { employees ->
            adapter.clear()
            for (employee in employees) {
                val expectation = if (employee.expectations.isNotEmpty()) employee.expectations else "No expectations set."
                adapter.add("${employee.name}: ${expectation}")
            }
            adapter.notifyDataSetChanged()
        })
    }
}
